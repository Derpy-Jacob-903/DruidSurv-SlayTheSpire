package druidsurv.powers.monkeys;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;

public class DefenderBuff extends AbstractEasyPower {
        public static final String POWER_ID = makeID("DefenderBuff");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

        public DefenderBuff(AbstractCreature owner, int amount) {
            super(POWER_ID, "Defender Strength", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new DefenderBuff(this.owner, this.amount);
        }
    }
