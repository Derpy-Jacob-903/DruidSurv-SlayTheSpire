package druidsurv.cards.nemesis.mox;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.NoLand;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;


@AutoAdd.Ignore
public class MoxVoidLand extends AbstractEasyCard {
    public MoxVoidLand() {
        super(makeID("MoxVoidLand"), 0, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_MOX_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        this.exhaust = true;
        magicNumber = baseMagicNumber;
        secondMagic = baseSecondMagic;
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        if (Objects.equals(card.cardID, this.cardID) && p().hasPower(NoLand.POWER_ID))
        {return false;}
        return super.canPlay(card);
    }

    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    public void onChoseThisOption() {
        addToBot(new ChannelAction(new MoxOrb(0, 0, 0, 1, 0, 0)));
        applyToSelfTop(new NoLand(p(), 1));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}