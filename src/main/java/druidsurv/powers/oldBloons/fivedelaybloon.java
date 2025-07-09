package druidsurv.powers.oldBloons;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BarricadePower;

import static druidsurv.ModFile.makeID;
@Deprecated
public class fivedelaybloon extends twodelaybloon{
    public static final String POWER_ID = makeID("5DelayBloon");
    public fivedelaybloon(AbstractCreature owner, int amount) {
        super(POWER_ID, "Looming Bloon", owner, amount);
    }
    public void atStartOfTurn() {
        //CascadeHandler s = new CascadeHandler();
        //s.cascade(this.owner, 5);
    }
    public int getHealthBarAmount() {
        int tmp = 0;
        if (this.owner.hasPower(BarricadePower.POWER_ID))
        {
            tmp += this.owner.currentBlock;
            tmp -= this.owner.getPower(fourdelaybloon.POWER_ID).amount;
        }
        return this.amount - tmp;
    }
}
