package druidsurv.cards.nemesis.mox;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.BrittleMox;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.BloontoniumPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxBoost extends AbstractEasyCard {
    public MoxBoost() {
        super(makeID("MoxClearBoost"), 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        baseBlock = 5;
        PersistFields.setBaseValue(this, 1);
        ExhaustiveVariable.setBaseValue(this, 1);
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        att(new AddTemporaryHPAction(p(), p(), secondMagic));
        MoxOrb orb = new BrittleMox(1, 1,1, 0);
        addToBot(new ChannelAction(orb));
    }

    public void upp() {
        upgradeBlock(5);
    }
}