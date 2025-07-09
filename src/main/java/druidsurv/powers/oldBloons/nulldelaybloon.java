package druidsurv.powers.oldBloons;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;
@Deprecated
public class nulldelaybloon extends AbstractEasyPower {
        public static final String POWER_ID = makeID("0DelayBloon");

        private static final PowerType TYPE = PowerType.DEBUFF;

        public static int amount = 0 ;

        private static final boolean TURN_BASED = false;

        public nulldelaybloon(AbstractCreature owner, int amount) {
            super(POWER_ID, "Null Bloon", TYPE, false, owner, amount);
        }

        public void atStartOfTurn()
        {
            //CascadeHandler s = new CascadeHandler();
            //s.cascade(this.owner, 999);
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new nulldelaybloon(this.owner, amount);
        }


    }
