package druidsurv.powers;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class
SunShieldPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("SunShieldPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public SunShieldPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Sun Shield", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

    public void atStartOfTurn() {
        addToBot((AbstractGameAction) new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractCreature p = this.owner;
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
            flash();
            addToTop((AbstractGameAction) new DamageAction(info.owner, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE, true));
            if (this.amount > 3) {
                addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, 3));
            } else {
                addToBot((AbstractGameAction) new RemoveSpecificPowerAction(this.owner, this.owner, this));
            }
        }
        return damageAmount; //<== Not changed
    }
        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new SunShieldPower(this.owner, this.amount);
        }
    }
