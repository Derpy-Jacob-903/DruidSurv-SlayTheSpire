package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class ToxicBloonPower extends BaseBloon {
        public static final String POWER_ID = makeID("BasicBloonPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public ToxicBloonPower(AbstractCreature owner, int delay, int health) {
            super(POWER_ID, "Red Bloon", TYPE, TURN_BASED, owner, delay, health);
        }

        public ToxicBloonPower(String id, String name, AbstractCreature owner, int delay, int health) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
        }
    public AbstractPower makeCopy() {
            return new ToxicBloonPower(this.owner, this.amount, this.amount2);
        }
}
