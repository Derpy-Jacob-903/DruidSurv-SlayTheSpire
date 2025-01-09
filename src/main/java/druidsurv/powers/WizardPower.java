package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class WizardPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("WizardStrength");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public WizardPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Wizard Strength", TYPE, false, owner, amount);
        }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new WizardPower(this.owner, this.amount);
        }
    }
