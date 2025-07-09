package druidsurv.powers.oldBloons;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BarricadePower;

import static druidsurv.ModFile.makeID;
@Deprecated
public class threedelaybloon extends twodelaybloon{
    public static final String POWER_ID = makeID("3DelayBloon");
    public threedelaybloon(AbstractCreature owner, int amount) {
        super(POWER_ID, "Approaching Bloon", owner, amount);
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
            tmp -= this.owner.getPower(twodelaybloon.POWER_ID).amount;
        }
        return this.amount - tmp;
    }
    public Color getColor() {
        return Color.TEAL;
    }
}
