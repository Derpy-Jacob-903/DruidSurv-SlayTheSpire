package druidsurv.cards.nemesis.mox;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;
import druidsurv.powers.NoLand;
import druidsurv.powers.mox.BlueMox;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.applyToSelfTop;
import static druidsurv.util.Wiz.p;

public class MoxBlueLand extends AbstractEasyCard {
    public MoxBlueLand() {
        super(makeID("MoxBlueLand"), 0, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE, CharacterFile.Enums.NEMDRUID_COLOR);
        baseMagicNumber = 1;
        baseSecondMagic = 5;
        this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC_MOX);
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
        applyToSelfTop(new BlueMox(p(), magicNumber));
        addToBot(new ChannelAction(new MoxOrb(0,0,1)));
        applyToSelfTop(new NoLand(p(), 1));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}