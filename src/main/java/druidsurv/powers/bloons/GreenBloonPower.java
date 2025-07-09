package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GrowthPower;

import static druidsurv.ModFile.makeID;

public class GreenBloonPower extends BaseBloon {
        public static final String POWER_ID = makeID("BasicBloonPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public int growth = 12;

        public GreenBloonPower(AbstractCreature owner, int delay, int health, int growth) {
            super(POWER_ID, "Steady Growth Bloon", TYPE, TURN_BASED, owner, delay, health);
            this.growth = (int)(health * 0.5);
        }

        public GreenBloonPower(String id, String name, AbstractCreature owner, int delay, int health, int growth) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
            this.growth = (int)(health * 0.5);
        }

    public void atEndOfTurn(boolean isPlayer) {
        this.amount2 += growth;
    }

    public AbstractPower makeCopy() {
            return new GreenBloonPower(this.owner, this.amount, this.amount2, this.growth);
        }
}
