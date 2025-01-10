package druidsurv.powers;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class ManaShieldPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("ManaShieldPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public ManaShieldPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Mana Shield", TYPE, false, owner, amount);
        }

        public void atStartOfTurn() {
            Object p;
            addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)this.owner, (AbstractCreature)this.owner, this.amount));
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new ManaShieldPower(this.owner, this.amount);
        }
    }
