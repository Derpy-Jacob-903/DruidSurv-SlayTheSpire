package druidsurv.cards.nemesis.mox;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.BloontoniumPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxDiamond extends AbstractEasyCard {
    public MoxDiamond() {
        super(makeID("MoxColorless"), 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        baseBlock = 5;
        PersistFields.setBaseValue(this, 2);
        ExhaustiveVariable.setBaseValue(this, 2);
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        blck();
        MoxOrb orb = new MoxOrb(2, 0);
        orb.DiamondMoxAction(2);
        //addToBot(new ChannelAction(orb));
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BloontoniumPower(AbstractDungeon.player, costForTurn), costForTurn));
    }

    public void upp() {
        upgradeBlock(5);
    }
}