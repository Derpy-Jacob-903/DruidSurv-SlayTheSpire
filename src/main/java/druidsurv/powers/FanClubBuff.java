package druidsurv.powers;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class FanClubBuff extends AbstractEasyPower {
        public static final String POWER_ID = makeID("SMFC");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public FanClubBuff(AbstractCreature owner, int amount) {
            super(POWER_ID, "Fan Club Buff", TYPE, false, owner, amount);
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new FanClubBuff(this.owner, this.amount);
        }
    }
