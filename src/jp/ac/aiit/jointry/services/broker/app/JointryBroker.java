package jp.ac.aiit.jointry.services.broker.app;

import jp.ac.aiit.jointry.services.broker.core.Broker;
import jp.ac.aiit.jointry.services.broker.core.HttpInfo;
import jp.ac.aiit.jointry.services.broker.core.ServerProxy;

public class JointryBroker extends Broker implements JointryCommon {

    public JointryBroker(int port, String market) throws Exception {
        super(port, market);
        this.setAccount(new JointryAccount());
    }

    @Override
    protected ServerProxy findServer(HttpInfo hinfo) {
        for (ServerProxy sp : spList()) {
            if (sp.canServeTo(hinfo)) {
                //プロキシIDと一致させ特定のサーバに紐づける
                if (sp.getID() == hinfo.getInt(PROXY_ID)) {
                    return sp;
                }
            }
        }
        return null;
    }
}
