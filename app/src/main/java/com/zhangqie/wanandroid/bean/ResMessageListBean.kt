package com.zhangqie.wanandroid.bean

/**
 * Created by L
 * 2018/9/12
 */
class ResMessageListBean {


    /**
     * dname+content+time
     * id : 5c905c4822f2276b85ad08f9
     * deviceId : 44444444444444444444
     * mtype : 1
     * ctime : 1536630828430
     * cuName : 12345678901
     * dname : 朱门
     * dkinds : kinds-1
     * dtype : 1
     * content : 操作成功
     * picture : pic.jgp
     * head : pic.jgp
     */
    var id: String? = null //消息ID
    var deviceId: String? = null //设备ID
    var mtype: Int = 0   //消息类型 1-操作消息，2-报警消息，3-开门失败消息
    var ctime: Long = 0 //操作时间
    var cuName: String? = null //操作用户名
    var dname: String? = null  //设备名称
    var dkinds: String? = null  //设备种类，比如不同的锁或不同的网关
    var dtype: Int = 0 //设备类型，1-网关，2-锁
    var content: String? = null  //消息内容
    var picture: String? = null//设备图片，URL前缀客户端拼接
    var head: String? = null//锁用户头像，URL前缀客户端拼接
}
