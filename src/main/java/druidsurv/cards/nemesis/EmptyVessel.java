package druidsurv.cards.nemesis;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.NemCharacterFile;
import druidsurv.actions.EasyModalChoiceAction;
import druidsurv.actions.MoxDiscoveryAction;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.cards.colorless.ModalChoiceMoxBlue;
import druidsurv.cards.colorless.ModalChoiceMoxGreen;
import druidsurv.cards.colorless.ModalChoiceMoxRuby;
import druidsurv.powers.BloontoniumPower;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class EmptyVessel extends AbstractPowerCostCard {
    public final static String ID = makeID("EmptyVessel");

    // intellij stuff skill, self, basic, , ,  5, 3, ,
    public EmptyVessel() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CharacterFile.Enums.NEMDRUID_COLOR, "EmptyVessel_CardArt", new RubyMox(null, 0));
        baseBlock = 5;
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        this.PowerCostId = RubyMox.POWER_ID;
        setOrbTexture("druidsurvResources/images/512/r_mox.png", "druidsurvResources/images/1024/r_mox.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelfTop(new BloontoniumPower(p(), magicNumber));
        AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(c -> c.hasTag(druidsurv.cards.cardvars.CardTags.BASIC_MOX));
        //eligibleCardsList.upgraded = this.upgraded;
        makeInHand(eligibleCardsList);

        //atb(new MoxDiscoveryAction(this.upgraded));
        /*ArrayList<AbstractCard> easyCardList = new ArrayList<>();
        easyCardList.add(new ModalChoiceMoxGreen());
        easyCardList.add(new ModalChoiceMoxRuby());
        easyCardList.add(new ModalChoiceMoxBlue());
        atb(new EasyModalChoiceAction(easyCardList));*/
    }

    @Override
    public void upp() {
        upgradeBlock(2);
    }
}