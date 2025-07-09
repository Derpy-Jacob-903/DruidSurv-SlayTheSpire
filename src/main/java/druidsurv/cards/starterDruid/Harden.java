package druidsurv.cards.starterDruid;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.ThornPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class Harden extends AbstractEasyCard {
    public final static String ID = makeID("HardenThorns");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Harden() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, "HardenThorns");
        baseMagicNumber = magicNumber = 1;
        setOrbTexture("druidsurvResources/images/512/bloontonium.png", "druidsurvResources/images/1024/bloontonium.png");
        setBackgroundTexture("druidsurvResources/images/512/hero_skill.png", "druidsurvResources/images/1024/hero_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new ThornPower(p, magicNumber)));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }
}