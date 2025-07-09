package druidsurv.powers.mox.lands;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;
@Deprecated
public class GreenMoxLand extends AbstractEasyPower {
        public static final String POWER_ID = makeID("GreenMoxPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public GreenMoxLand(AbstractCreature owner, int amount) {
            super(POWER_ID, "Emerald Land", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }
    public void atStartOfTurn() {
        applyToSelfTop(new GreenMox(p(), amount));
    }

    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power instanceof GreenMoxLand){
            CardCrawlGame.sound.play("ORB_LIGHTNING_CHANNEL", 0.1F);}
    }

    public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0];
        }

        public AbstractPower makeCopy() {
            return new GreenMoxLand(this.owner, this.amount);
        }
    }
