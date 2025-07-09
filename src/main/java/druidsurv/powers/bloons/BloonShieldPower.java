package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;

public class BloonShieldPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("ManaShieldPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = false;

        public BloonShieldPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Bubble Shield", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
        {
            AbstractCreature p = this.owner;
            if (info.type != DamageInfo.DamageType.HP_LOSS)
            {
                if( p.currentBlock < damageAmount) {
                    addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, p.currentBlock));
                }
                else {
                    addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, damageAmount));
                }
            }
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new BloonShieldPower(this.owner, this.amount);
        }
    }
