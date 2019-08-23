package com.zhangqie.wanandroid.bean

/**
 * Created by L
 * 2019-05-22
 */
class RspGatewayInfosBean {

    /**
     * bindedGateway : {"gatewayId":55555555555555,"name":"名称","picture":"xxx.jpg"}
     * gateways : [{"gatewayId":55555555555555,"name":"名称","picture":"xxx.jpg"}]
     */

    var bindedGateway: BindedGatewayBean? = null
    var gateways: List<GatewaysBean>? = null

    override fun toString(): String {
        return "RspGatewayInfosBean{" +
                "bindedGateway=" + bindedGateway +
                ", gateways=" + gateways +
                '}'.toString()
    }

    class BindedGatewayBean {
        /**
         * gatewayId : 55555555555555
         * name : 名称
         * picture : xxx.jpg
         */

        var gatewayId: Long = 0
        var name: String? = null
        var picture: String? = null

        override fun toString(): String {
            return "BindedGatewayBean{" +
                    "gatewayId=" + gatewayId +
                    ", name='" + name + '\''.toString() +
                    ", picture='" + picture + '\''.toString() +
                    '}'.toString()
        }
    }

    class GatewaysBean {
        /**
         * gatewayId : 55555555555555
         * name : 名称
         * picture : xxx.jpg
         */

        var gatewayId: Long = 0
        var name: String? = null
        var picture: String? = null

        override fun toString(): String {
            return "GatewaysBean{" +
                    "gatewayId=" + gatewayId +
                    ", name='" + name + '\''.toString() +
                    ", picture='" + picture + '\''.toString() +
                    '}'.toString()
        }
    }
}
