package druidsurv.cards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class EasyModalChoiceCard extends AbstractEasyCard {

    private Runnable onUseOrChosen;
    private String passedName;
    private String passedDesc;

    public EasyModalChoiceCard(String name, String description, Runnable onUseOrChosen) {
        super(makeID(name), -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS);
        this.name = this.originalName = passedName = name;
        this.rawDescription = passedDesc = description;
        this.onUseOrChosen = onUseOrChosen;
        initializeTitle();
        initializeDescription();
    }

    public EasyModalChoiceCard(Runnable onUseOrChosen) {
        super("", -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS);
        CardStrings cardStrings2 = CardCrawlGame.languagePack.getCardStrings(this.cardID);
        rawDescription = cardStrings2.DESCRIPTION;
        name = originalName = cardStrings2.NAME;
        this.onUseOrChosen = onUseOrChosen;
        initializeTitle();
        initializeDescription();
    }

    public EasyModalChoiceCard() {
        super("", -2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS);
        CardStrings cardStrings2 = CardCrawlGame.languagePack.getCardStrings(this.cardID);
        rawDescription = cardStrings2.DESCRIPTION;
        name = originalName = cardStrings2.NAME;
        initializeTitle();
        initializeDescription();
    }

    @Override
    public void onChoseThisOption() {
        onUseOrChosen.run();
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onUseOrChosen.run();
    }

    @Override
    public void upp() {

    }

    @Override
    public boolean canUpgrade() {
        return false;
    }

    @Override
    public void upgrade() {
    }

    @Override
    public AbstractCard makeCopy() {
        return new EasyModalChoiceCard(passedName, passedDesc, onUseOrChosen);
    }
}
