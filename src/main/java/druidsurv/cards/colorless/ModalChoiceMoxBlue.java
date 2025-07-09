package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.EasyModalChoiceCard;
import druidsurv.powers.mox.BlueMox;
import druidsurv.powers.mox.GreenMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;

public class ModalChoiceMoxBlue extends AbstractEasyCard {
    public ModalChoiceMoxBlue() {
        super(makeID("ModalChoiceMoxBlue"), -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS, "");
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
        applyToSelfTop(new BlueMox(p(), magicNumber));
    }

    public void upp() {
    }
}