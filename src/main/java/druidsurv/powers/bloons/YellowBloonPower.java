package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class YellowBloonPower extends BaseBloon {
        public static final String POWER_ID = makeID("Yellow Bloon");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public YellowBloonPower(AbstractCreature owner, int delay, int health) {
            super(POWER_ID, "Yellow Bloon", TYPE, TURN_BASED, owner, delay, health);
        }

        public YellowBloonPower(String id, String name, AbstractCreature owner, int delay, int health) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
        }
    public AbstractPower makeCopy() {
            return new YellowBloonPower(this.owner, this.amount, this.amount2);
        }
}
