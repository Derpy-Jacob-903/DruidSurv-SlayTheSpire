package druidsurv.cards.nemesis.mox;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.mox.BlueMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxBlueVessel extends AbstractPowerCostCard {
    public MoxBlueVessel() {
        super(makeID("MoxBlueVessel"), 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_MOX_COLOR);
        baseMagicNumber = 2;
        baseSecondMagic = 4;
        this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC_MOX);
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        att(new AddTemporaryHPAction(p(), p(), secondMagic));
        applyToSelfTop(new BlueMox(p(), magicNumber));
        addToBot(new ChannelAction(new MoxOrb(0,0,1)));
    }

    public void upp() {
        upgradeSecondMagic(5);
    }
}