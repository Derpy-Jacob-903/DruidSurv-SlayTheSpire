package druidsurv.powers;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static druidsurv.ModFile.makeID;

//Crazy ass class name :skull:
//public class weakeninggas extends AbstractEasyPower implements HealthBarRenderPower {
public class ShieldGasPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("ShieldGasPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = true;

        public ShieldGasPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Shield Gas", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void atStartOfTurn()
        {
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, 15));
        }

    public int onLoseHp(int damageAmount) {
        addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new WeakPower(this.owner, this.amount, false), this.amount, true, AbstractGameAction.AttackEffect.NONE));
        return damageAmount;
    }

    public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount;
        }

    public AbstractPower makeCopy() {
            return new ShieldGasPower(this.owner, this.amount);
        }
}
