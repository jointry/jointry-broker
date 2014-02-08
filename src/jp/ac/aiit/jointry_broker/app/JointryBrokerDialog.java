package jp.ac.aiit.jointry_broker.app;

import jp.ac.aiit.jointry_broker.core.DInfo;
import jp.ac.aiit.jointry_broker.core.DialogBase;

public class JointryBrokerDialog extends DialogBase {

    private static boolean installed = false;

    public static void install() {
        if (!installed) {
            DialogBase.addDialog(JointryCommon.D_MAIN, JointryBrokerDialog.class);
            DialogBase.addDialog(JointryCommon.D_SPRITE, JointryBrokerDialog.class);
            DialogBase.addDialog(JointryCommon.D_BLOCK, JointryBrokerDialog.class);

            installed = true;
        }
    }

    @Override
    public void onAnswer(final DInfo dinfo) {

    }

    @Override
    public void onQuery(final DInfo dinfo) {

    }

    @Override
    public void onNotify(final DInfo dinfo) {

    }
}
