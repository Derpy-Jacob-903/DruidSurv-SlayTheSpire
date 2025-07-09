package druidsurv.cards.democards.complex;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.actions.EasyModalChoiceAction;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.EasyModalChoiceCard;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

@AutoAdd.Ignore
public class EasyModalChoiceDemo extends AbstractEasyCard {
    public final static String ID = makeID(EasyModalChoiceDemo.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , , 

    public EasyModalChoiceDemo() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
        baseSecondMagic = secondMagic = 1;
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_skill_hidden.png", "druidsurvResources/images/cardui/1024/frame_skill_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> easyCardList = new ArrayList<>();
        easyCardList.add(new EasyModalChoiceCard(cardStrings.EXTENDED_DESCRIPTION[0], cardStrings.EXTENDED_DESCRIPTION[1] + magicNumber + cardStrings.EXTENDED_DESCRIPTION[2], () -> att(new DrawCardAction(magicNumber))));
        easyCardList.add(new EasyModalChoiceCard(cardStrings.EXTENDED_DESCRIPTION[3], cardStrings.EXTENDED_DESCRIPTION[4]+ secondMagic + cardStrings.EXTENDED_DESCRIPTION[5], () -> applyToSelfTop(new StrengthPower(p, secondMagic))));
        atb(new EasyModalChoiceAction(easyCardList));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
        upgradeSecondMagic(1);
    }
}