package com.learning.springboot.generatedata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * 表结构：
 * CREATE TABLE `cust_order` (
 * `CUST_ORDER_ID` decimal(12,0) NOT NULL COMMENT '客户订单标识',
 * `CUST_ORDER_NBR` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '客户订单号',
 * `A_PARTY_CODE` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '购买人信息',
 * `A_PARTY_TYPE` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '客户、证件、客户名称、号码等',
 * `CERT_TYPE` decimal(3,0) DEFAULT NULL COMMENT '证件类型',
 * `CUST_ID` decimal(12,0) DEFAULT NULL COMMENT '客户标识',
 * `PROMOTION_PLAN_ID` decimal(6,0) DEFAULT NULL COMMENT '优惠计划标识',
 * `ORDER_STATE` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单状态',
 * `STATE_DATE` datetime DEFAULT NULL COMMENT '状态时间',
 * `ACCEPT_DATE` datetime NOT NULL COMMENT '业务办理的日期(办理日期有可能比订单建立日期早，如WEB受理时并没及时进入到申请信息表)',
 * `CREATED_DATE` datetime NOT NULL COMMENT '客户订单创建时的系统时间',
 * `PARTY_TYPE` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参与方类型',
 * `PARTY_CODE` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参与方标识，可能是STAFF_JOB.ID、BANK_ID、CUST_ID、AGENT_ID',
 * `CONTACT` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系信息',
 * `IP_ADDRESS` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'IP地址',
 * `CONFIRM_DATE` datetime DEFAULT NULL COMMENT '确认时间',
 * `DISCOUNT_CHARGE` decimal(15,0) DEFAULT NULL COMMENT '优惠金额',
 * `DISPATCH_ORDER_ID` decimal(14,0) DEFAULT NULL COMMENT '调度单标识',
 * `SP_ID` decimal(6,0) DEFAULT NULL COMMENT 'SP_ID',
 * `PART_ID` decimal(6,0) DEFAULT NULL COMMENT 'PART_ID',
 * KEY `IDX_CO_ACC_DATE` (`ACCEPT_DATE`) USING BTREE,
 * KEY `IDX_CO_CREATE_DATE` (`CREATED_DATE`) USING BTREE,
 * KEY `IDX_CUST_ORDER_CUST_ID` (`CUST_ID`) USING BTREE,
 * KEY `PK_CUST_ORDER` (`CUST_ORDER_ID`) USING BTREE
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
 * <p>
 * 生成日志数据格式
 * CUST_ORDER_ID,CUST_ORDER_NBR,A_PARTY_CODE,A_PARTY_CODE,A_PARTY_TYPE
 *
 * @author morning
 * @date 2020/9/22 18:33
 * @since 0.0.1
 */
public class BatchGenerateCustOrder {
    Logger logger0 = LoggerFactory.getLogger("CustOrder0");
    Logger logger1= LoggerFactory.getLogger("CustOrder1");
    Logger logger2 = LoggerFactory.getLogger("CustOrder2");
    Logger logger3 = LoggerFactory.getLogger("CustOrder3");
    Logger logger4 = LoggerFactory.getLogger("CustOrder4");
    Logger logger5 = LoggerFactory.getLogger("CustOrder5");
    Logger logger6 = LoggerFactory.getLogger("CustOrder6");
    Logger logger7 = LoggerFactory.getLogger("CustOrder7");

    Logger logger8 = LoggerFactory.getLogger("CustOrder8");
    Logger logger9 = LoggerFactory.getLogger("CustOrder9");
    Logger logger10 = LoggerFactory.getLogger("CustOrder10");
    Logger logger11 = LoggerFactory.getLogger("CustOrder11");
    Logger logger12 = LoggerFactory.getLogger("CustOrder12");
    Logger logger13 = LoggerFactory.getLogger("CustOrder13");
    Logger logger14 = LoggerFactory.getLogger("CustOrder14");
    Logger logger15 = LoggerFactory.getLogger("CustOrder15");

    Logger logger16 = LoggerFactory.getLogger("CustOrder16");
    Logger logger17= LoggerFactory.getLogger("CustOrder17");
    Logger logger18 = LoggerFactory.getLogger("CustOrder18");
    Logger logger19 = LoggerFactory.getLogger("CustOrder19");
    Logger logger20 = LoggerFactory.getLogger("CustOrder20");
    Logger logger21 = LoggerFactory.getLogger("CustOrder21");
    Logger logger22 = LoggerFactory.getLogger("CustOrder22");
    Logger logger23 = LoggerFactory.getLogger("CustOrder23");

    private Map<String, Logger> loggerMap;
    public BatchGenerateCustOrder() {
        loggerMap = init();
    }

    /**
     * 数据格式：
     * k,c,pad
     *
     * @author weiyt
     * @date 2020/9/22 15:48
     * @since 3.1.0-SNAPSHOT
     */
    public void generate(long num, int sharding) {
        for (long i = 0; i < num; i++) {
            int mod = (int)(i % sharding);
            loggerData(i, mod);
        }
    }

    public Map<String, Logger> init() {
        Map<String, Logger>  map =  new HashMap<String, Logger>(){
            {
                put("logger0", logger0);
                put("logger1", logger1);
                put("logger2", logger2);
                put("logger3", logger3);
                put("logger4", logger4);
                put("logger5", logger5);
                put("logger6", logger6);
                put("logger7", logger7);
                put("logger8", logger8);
                put("logger9", logger9);
                put("logger10", logger10);
                put("logger11", logger11);
                put("logger12", logger12);
                put("logger13", logger13);
                put("logger14", logger14);
                put("logger15", logger15);
                put("logger16", logger16);
                put("logger17", logger17);
                put("logger18", logger18);
                put("logger19", logger19);
                put("logger20", logger20);
                put("logger21", logger21);
                put("logger22", logger22);
                put("logger23", logger23);
            }
        };

        return map;
    }

    /**
     * 生成数据文件
     * @param i
     */
    private void loggerData(long i, int mod) {
        String format = "{},{},{},{},{},,{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}";
        CustOrder c = new CustOrder(i);
        String key = "logger" + mod;
        Logger logger = loggerMap.get(key);
        logger.debug(format, c.custOrderId, c.custOrderNbr,c.aPartyCode,c.aPartyType,c.certType,
                    c.custId,c.promotionPlanId,c.orderState,c.stateDate,c.acceptDate,c.createDate,
                    c.partyType,c.partyCode,c.contact,c.ipAddress,c.confirmDate,c.discountCharge,
                    c.dispatchOrderId,c.spId,c.partId);
    }

    /**
     * 构造数据
     */
    class CustOrder {

        public CustOrder(long i) {
            this.custOrderId = String.valueOf(i);
            this.custOrderNbr = String.valueOf(i);
            this.aPartyCode = "20320";
            this.aPartyType = "D";
            this.certType = "123456789";
            this.custId = String.valueOf(i);
            this.promotionPlanId = "1";
            this.orderState = "C";
            this.stateDate = "2020-08-03 11:36:15";
            this.acceptDate = "2020-08-03 11:39:36";
            this.createDate = "2020-08-03 11:35:36";
            this.partyType = "A";
            this.partyCode = "1";
            this.contact = "123456789";
            this.ipAddress = "127.0.0.1";
            this.confirmDate = "2020-08-03 11:39:36";
            this.discountCharge = "10";
            this.dispatchOrderId = "249";
            this.spId = "0";
            this.partId ="248";
        }

        String custOrderId;
        String custOrderNbr;
        String aPartyCode;
        String aPartyType;
        String certType;
        String custId;
        String promotionPlanId;
        String orderState;
        String stateDate;
        String acceptDate;
        String createDate;
        String partyType;
        String partyCode;
        String contact;
        String ipAddress;
        String confirmDate;
        String discountCharge;
        String dispatchOrderId;
        String spId;
        String partId;
    }
}
