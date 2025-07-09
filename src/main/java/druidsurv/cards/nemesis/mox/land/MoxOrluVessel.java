package druidsurv.cards.nemesis.mox.land;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.orbs.mox.TapMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxOrluVessel extends AbstractPowerCostCard {
    public MoxOrluVessel() {
        super(makeID("MoxOrluVessel"), 2, CardType.SKILL, CardRarity.RARE, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 10;
        this.exhaust = true;
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        att(new AddTemporaryHPAction(p(), p(), secondMagic));
        addToBot(new ChannelAction(new TapMox(0,1,1)));
    }

    public void upp() {
        upgradeSecondMagic(5);
    }
}