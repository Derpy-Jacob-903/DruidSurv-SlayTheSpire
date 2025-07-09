package druidsurv.cards.nemesis;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.BloontoniumPower;
import druidsurv.powers.mox.BlueMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MoxDraw extends AbstractEasyCard {
    public MoxDraw() {
        super(makeID("MoxDraw"), 1, CardType.POWER, CardRarity.RARE, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
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
        //att(new AddTemporaryHPAction(p(), p(), 5));
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BloontoniumPower(AbstractDungeon.player, costForTurn), costForTurn));
    }

    public void upp() {
        upgradeBlock(5);
    }
}