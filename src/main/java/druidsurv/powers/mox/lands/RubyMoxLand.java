package druidsurv.powers.mox.lands;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.powers.mox.RubyMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;
@Deprecated
public class RubyMoxLand extends AbstractEasyPower {
        public static final String POWER_ID = makeID("RubyMoxPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;


        public RubyMoxLand(AbstractCreature owner, int amount) {
            super(POWER_ID, "Ruby Land", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

    public void atStartOfTurn() {
        applyToSelfTop(new RubyMox(p(), amount));
    }
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power instanceof RubyMoxLand){
            CardCrawlGame.sound.play("ORB_FROST_CHANNEL", 0.1F);}
    }

    public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0];
        }

        public AbstractPower makeCopy() {
            return new RubyMoxLand(this.owner, this.amount);
        }
    }
