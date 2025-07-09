package druidsurv.powers.oldBloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

@Deprecated //Black Bloon now uses DrawCardNextTurnPower
public class blackbloonzero extends zerodelaybloon {
    public static final String POWER_ID = makeID("0DelayBlackBloon");
    public blackbloonzero(AbstractCreature owner, int amount) {
        super(owner, amount);
    }

    public void atStartOfTurn() {
        atb(new DrawCardAction(1));
        addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
    }
}
