package com.nhnacademy.shoppingmall.common.mvc.transaction;

import com.nhnacademy.shoppingmall.common.util.DbUtils;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;

@Slf4j
public class DbConnectionThreadLocal {
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> sqlErrorThreadLocal = ThreadLocal.withInitial(()->false);

    public static void initialize(){

        //todo#2-1 - connection pool에서 connectionThreadLocal에 connection을 할당합니다.
        Connection connection = null;
        try {
            connection = DbUtils.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("[DbConnectionThreadLocal] : pool에서 connection을 얻지 못했습니다.", e);
        }
        connectionThreadLocal.set(connection);

        try {
            //todo#2-2 connection의 Isolation level을 READ_COMMITTED를 설정 합니다.
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            //todo#2-3 auto commit을 false로 설정합니다.
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException("Error setting transaction properties", e);
        }

    }

    public static Connection getConnection(){
        return connectionThreadLocal.get();
    }

    public static void setSqlError(boolean sqlError){
        sqlErrorThreadLocal.set(sqlError);
    }

    public static boolean getSqlError(){
        return sqlErrorThreadLocal.get();
    }

    public static void reset(){
        Connection resetConnection = connectionThreadLocal.get();

        //todo#2-4 사용이 완료된 connection은 close를 호출하여 connection pool에 반환합니다.
        if(resetConnection != null){
            try {
                resetConnection.close();
            } catch (Exception e) {
                log.error("connection close error", e);
            }
        }

        //todo#2-5 getSqlError() 에러가 존재하면 rollback 합니다.
        if(getSqlError()){
            try {
                assert resetConnection != null;
                resetConnection.rollback();
            } catch (Exception e) {
                log.error("rollback error", e);
            }
        }

        //todo#2-6 getSqlError() 에러가 존재하지 않다면 commit 합니다.
        else{
            try {
                assert resetConnection != null;
                resetConnection.commit();
            } catch (Exception e) {
                log.error("commit error", e);
            }
        }

        //todo#2-7 현제 사용하고 있는 connection을 재 사용할 수 없도록 connectionThreadLocal을 초기화 합니다.
        connectionThreadLocal.remove();
    }
}
