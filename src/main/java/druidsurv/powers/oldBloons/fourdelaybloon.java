package druidsurv.powers.oldBloons;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BarricadePower;

import static druidsurv.ModFile.makeID;
@Deprecated
public class fourdelaybloon extends twodelaybloon{
    public static final String POWER_ID = makeID("4DelayBloon");
    public fourdelaybloon(AbstractCreature owner, int amount) {
        super(POWER_ID, "Looming Bloon", owner, amount);
    }
    public void atStartOfTurn() {
        //CascadeHandler s = new CascadeHandler();
        //s.cascade(this.owner, 3);
    }
    public int getHealthBarAmount() {
        int tmp = 0;
        if (this.owner.hasPower(BarricadePower.POWER_ID))
        {
            tmp += this.owner.currentBlock;
            tmp -= this.owner.getPower(threedelaybloon.POWER_ID).amount;
        }
        return this.amount - tmp;
    }
}
