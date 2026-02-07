package models;

import models.constants.GateStatus;
import models.constants.GateType;

public class Gates extends BaseModel {
    private GateType gateType;
        private GateStatus gateStatus;
        private Opreator opreator;

    public Gates(GateStatus gateStatus, int no_of_entery, int no_of_exit, Opreator opreator) {
        this.gateStatus = gateStatus;
        this.opreator = opreator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Opreator getOpreator() {
        return opreator;
    }

    public void setOpreator(Opreator opreator) {
        this.opreator = opreator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
