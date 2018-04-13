package com.xiao.ex.common;

import com.xiao.ex.service.MsgService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.BeanFactoryUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 任务创建工厂
 *
 * @author 肖亭
 * @since 2017年11月14 18:31
 **/
public class CreteMsgFactory {

    /**
     * MsgService 对象集合
     */
    private static Set<MsgService> IMSG_BEAN = null;

    /**
     * 创建用户实际操作的对象
     *
     * @return ICoreAccount
     */
    public static Set<MsgService> creteMsgBean() {
        getIMsgBean();
        if (CollectionUtils.isEmpty(IMSG_BEAN)) {
            return null;
        }
        return IMSG_BEAN;
    }
    /**
     * 获取IFindTaskList所有的子类成员
     */
    private static void getIMsgBean() {
        if (CollectionUtils.isNotEmpty(IMSG_BEAN)) {
            return;
        }
        Map<String, MsgService> beanMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(SpringContextUtil.getApplicationContext(), MsgService.class, true, true);
        if (beanMap == null || beanMap.isEmpty()) {
            return;
        }
        IMSG_BEAN = new HashSet<>(beanMap.values());
    }
}
