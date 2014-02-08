package jp.ac.aiit.jointry_broker.app;

import jp.ac.aiit.jointry_broker.core.Account;

public class JointryAccount extends Account {

    @Override
    public void save() {
        //機能無効
    }

    @Override
    public boolean certify(String name, String password) {
        return true; //パスワード認証は行わない
    }

    @Override
    public boolean isActiveUser(String name) {
        boolean result = super.isActiveUser(name);
        if (result && JointryCommon.DUMMY_AGENT_NAME.equals(name)) {
            return false;
        }

        return result;
    }
}
