package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class DiscountBloonPower extends BaseBloon {
        public static final String POWER_ID = makeID("BasicBloonPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public DiscountBloonPower(AbstractCreature owner, int delay, int health) {
            super(POWER_ID, "Green Bloon", TYPE, TURN_BASED, owner, delay, health);
        }

        public DiscountBloonPower(String id, String name, AbstractCreature owner, int delay, int health) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
        }
    public AbstractPower makeCopy() {
            return new DiscountBloonPower(this.owner, this.amount, this.amount2);
        }
}
