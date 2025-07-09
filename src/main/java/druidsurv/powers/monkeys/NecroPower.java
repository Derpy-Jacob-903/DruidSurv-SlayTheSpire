package druidsurv.powers.monkeys;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.colorless.UndeadBloon;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class NecroPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("NecroPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public NecroPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Necromancy", TYPE, false, owner, amount);
        }

        public void atStartOfTurn()
        {
            makeInHand(new UndeadBloon());
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new NecroPower(this.owner, this.amount);
        }
    }
