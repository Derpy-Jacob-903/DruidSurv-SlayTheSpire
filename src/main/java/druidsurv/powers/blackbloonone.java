package druidsurv.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class blackbloonone extends onedelaybloon{
    public static final String POWER_ID = makeID("1DelayBlackBloon");
    public blackbloonone(AbstractCreature owner, int amount) {
        super(owner, amount);
    }

    public void atStartOfTurn() {
        addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new blackbloonzero(this.owner, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, 1));
    }
}
