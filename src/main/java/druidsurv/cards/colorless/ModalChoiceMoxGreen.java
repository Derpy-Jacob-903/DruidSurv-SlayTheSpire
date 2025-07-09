package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.EasyModalChoiceCard;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;

public class ModalChoiceMoxGreen extends AbstractEasyCard {
    public ModalChoiceMoxGreen() {
        super(makeID("ModalChoiceMoxGreen"), -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS);
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
        applyToSelfTop(new GreenMox(p(), magicNumber));
    }

    public void upp() {
    }
}

