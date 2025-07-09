package druidsurv.powers.monkeys;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;

public class JBPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("JungleBounty");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public JBPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Jungle's Bounty", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

    public void atEnergyGain() {
        addToBot((AbstractGameAction)new HealAction(this.owner, this.owner, this.amount));
    }

    public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new JBPower(this.owner, this.amount);
        }
    }
