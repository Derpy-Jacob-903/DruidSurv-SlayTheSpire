package druidsurv.powers;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BarricadePower;

import static druidsurv.ModFile.makeID;

public class fourdelaybloon extends twodelaybloon{
    public static final String POWER_ID = makeID("4DelayBloon");
    public fourdelaybloon(AbstractCreature owner, int amount) {
        super(POWER_ID, "Looming Bloon", owner, amount);
    }
    public void atStartOfTurn() {
        addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new threedelaybloon(this.owner, amount), amount, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
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
