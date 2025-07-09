package druidsurv.powers;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class BloontoniumCachePower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("BloontoniumPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
    }

        public BloontoniumCachePower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Bloontonium Cache", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new BloontoniumCachePower(this.owner, this.amount);
        }
    }
