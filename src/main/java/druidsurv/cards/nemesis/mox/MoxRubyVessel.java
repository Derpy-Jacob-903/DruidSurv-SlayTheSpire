package druidsurv.cards.nemesis.mox;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.mox.RubyMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxRubyVessel extends AbstractPowerCostCard {
    public MoxRubyVessel() {
        super(makeID("MoxRubyVessel"), 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_MOX_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
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
        applyToSelfTop(new RubyMox(p(), magicNumber));
        addToBot(new ChannelAction(new MoxOrb(0,1,0)));
    }

    public void upp() {
        upgradeSecondMagic(5);
    }
}