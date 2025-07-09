package druidsurv.powers.mox.lands;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.powers.BloontoniumPower;
import druidsurv.powers.mox.BlueMox;
import druidsurv.util.ProAudio;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

@Deprecated
public class BaseMoxVessel extends AbstractEasyPower implements NonStackablePower {
        public static final String POWER_ID = makeID("BaseMoxVesselPower");

        public boolean canbr8k = false;
        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public BaseMoxVessel(AbstractCreature owner, int amount) {
            super(POWER_ID, "Base Land", TYPE, false, owner, amount);
            this.canGoNegative = false;
            this.amount2 = -1;
        }

        public BaseMoxVessel(AbstractCreature owner, int amount, int amount2, String name) {
            super(POWER_ID, name, TYPE, false, owner, amount);
            this.canGoNegative = false;
            this.canbr8k = true;
            this.amount2 = amount2;
        }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (this.canbr8k)
        {
            this.amount2 -= damageAmount;
        }
        if (this.canbr8k && this.amount2 <= 0 )
        {
            playAudio(ProAudio.disk_card_death);
            removePower(this);
        }
        return super.onAttacked(info, damageAmount);
    }

    public void atStartOfTurn() {
        applyToSelfTop(new BlueMox(p(), amount));
    }

    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power instanceof BaseMoxVessel){
            CardCrawlGame.sound.play("ORB_PLASMA_CHANNEL", 0.1F);}
    }

    public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0];
        }

        public AbstractPower makeCopy() {
            return new BaseMoxVessel(this.owner, this.amount);
        }
    }
