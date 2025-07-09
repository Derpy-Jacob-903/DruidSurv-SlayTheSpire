package druidsurv.powers.monkeys;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;

@Deprecated
public class FanClubBuff extends AbstractEasyPower {
        public static final String POWER_ID = makeID("SMFCPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

        public FanClubBuff(AbstractCreature owner, int amount) {
            super(POWER_ID, "Fan Club Strength", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new FanClubBuff(this.owner, this.amount);
        }
    }
