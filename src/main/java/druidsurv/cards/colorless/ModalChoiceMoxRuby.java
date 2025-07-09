package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.EasyModalChoiceCard;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;

public class ModalChoiceMoxRuby extends AbstractEasyCard {
    public ModalChoiceMoxRuby() {
        super(makeID("ModalChoiceMoxRuby"), -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS);
        baseMagicNumber = 1;
        baseSecondMagic = 2;
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
        setBackgroundTexture("druidsurvResources/images/512/nem_mox.png", "druidsurvResources/images/1024/nem_mox.png");
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        applyToSelfTop(new RubyMox(p(), magicNumber));
    }

    public void upp() {
    }
}
