package druidsurv.powers;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class ManaShieldPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("ManaShieldPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public ManaShieldPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Shield", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }
        public void atEndOfTurn(boolean isPlayer) {
            addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)this.owner, (AbstractCreature)this.owner, this.amount));
        }

    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractCreature p = this.owner;
        if (info.type != DamageInfo.DamageType.HP_LOSS)
        {
            if( p.currentBlock < info.output) {
                addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, p.currentBlock));
            }
            else {
                addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, (AbstractPower)this, info.output));
            }
            return damageAmount; //<== Not changed
        }
        return damageAmount; //<== Not changed
    }

    public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new ManaShieldPower(this.owner, this.amount);
        }
    }
