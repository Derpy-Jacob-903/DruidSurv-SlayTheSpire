package druidsurv.powers.bloons;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class BasicBloonPower extends BaseBloon{
        public static final String POWER_ID = makeID("BasicBloonPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public BasicBloonPower(AbstractCreature owner, int delay, int health) {
            super(POWER_ID, "Red Bloon", TYPE, TURN_BASED, owner, delay, health);
        }

        public BasicBloonPower(AbstractCreature owner, int delay, int health, String name) {
            super(POWER_ID, name, TYPE, TURN_BASED, owner, delay, health);
        }

        public BasicBloonPower(String id, String name, AbstractCreature owner, int delay, int health) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
        }
    public AbstractPower makeCopy() {
            return new BasicBloonPower(this.owner, this.amount, this.amount2);
        }
}
