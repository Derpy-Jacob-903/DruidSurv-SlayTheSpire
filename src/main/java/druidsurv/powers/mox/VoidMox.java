package druidsurv.powers.mox;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;

public class VoidMox extends AbstractEasyPower {
        public static final String POWER_ID = makeID("VoidMoxPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 4)
            this.amount = 4;
    }

        public VoidMox(AbstractCreature owner, int amount) {
            super(POWER_ID, "Void Mox", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

    public void atEndOfTurn(boolean isPlayer) {
        if (isPlayer) { addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));}
    }
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power instanceof VoidMox){
            CardCrawlGame.sound.play("ORB_DARK_CHANNEL", 0.1F);}
    }

    public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0];
        }

        public AbstractPower makeCopy() {
            return new VoidMox(this.owner, this.amount);
        }
    }
