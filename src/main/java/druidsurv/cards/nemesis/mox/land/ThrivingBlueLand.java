package druidsurv.cards.nemesis.mox.land;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.orbs.mox.TapMox;
import druidsurv.powers.NoLand;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;

public class ThrivingBlueLand extends AbstractEasyCard {
    public ThrivingBlueLand() {
        super(makeID("ThrivingBlueLand"), 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        this.exhaust = true;
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        addToBot(new ChannelAction(new TapMox(0,0,2)));
        applyToSelfTop(new NoLand(p(), 1));
    }

    public void upp() {
        upgradeSecondMagic(5);
    }
}